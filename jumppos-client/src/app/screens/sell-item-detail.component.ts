import { IScreen } from './iscreen';
import {Component} from '@angular/core';
import {ISellItem} from './sell.component';
import {SessionService} from '../session.service';

@Component({
  selector: 'app-sell-item-detail',
  templateUrl: './sell-item-detail.component.html'
})

export class SellItemDetailComponent implements IScreen {
  public item: ISellItem;

  constructor(public session: SessionService ) {
    this.item = session.screen.item;
  }

  show(session: SessionService) {
  }

}
