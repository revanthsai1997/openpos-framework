import { DynamicScreenComponent } from './../screens/dynamic-screen/dynamic-screen.component';
import { IScreen } from './iscreen';
import { OverlayContainer } from '@angular/cdk/overlay';
import { ViewChild, ComponentFactory, ViewContainerRef, ComponentRef } from '@angular/core';
import { ScreenDirective } from './screen.directive';
import { SessionService } from '../services/session.service';

export abstract class AbstractTemplate implements IScreen {

    @ViewChild(ScreenDirective) host: ScreenDirective;

    private currentScreenRef: ComponentRef<IScreen>;

    private actionDisablers = new Map<string, actionShouldBeDisabled>();

    constructor() {
    }

    public installScreen(screenComponentFactory: ComponentFactory<IScreen>, session: SessionService): IScreen {
        const viewContainerRef = this.host.viewContainerRef;
        viewContainerRef.clear();
        if (this.currentScreenRef) {
            this.currentScreenRef.destroy();
        }
        this.currentScreenRef = viewContainerRef.createComponent(screenComponentFactory);
        return this.currentScreenRef.instance;
    }

    abstract show(screen: any);

    // tslint:disable-next-line:no-shadowed-variable
    registerActionDisabler(action: string, actionShouldBeDisabled) {
        this.actionDisablers.set(action, actionShouldBeDisabled);
    }

    actionIsDisabled(action: string): boolean {
        if (this.actionDisablers.has(action)) {
            return this.actionDisablers.get(action)();
        }

        return false;
    }
}

export type actionShouldBeDisabled = () => boolean;
