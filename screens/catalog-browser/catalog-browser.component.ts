import { Component, ViewChild } from '@angular/core';
import {  MatPaginator, PageEvent } from '@angular/material';
import { IScreen } from '../../core/components';
import { ISellItem, IMenuItem } from '../../core/interfaces';
import { SessionService } from '../../core';

@Component({
    selector: 'app-catalog-browser',
    templateUrl: './catalog-browser.component.html',
    styleUrls: ['./catalog-browser.component.scss']
  })
  export class CatalogBrowserComponent implements IScreen {
    @ViewChild('drawer') drawer;
    @ViewChild(MatPaginator) paginator;
  
    screen: IScreen;
    items: ISellItem[];
    categories: IMenuItem[];
    maxItemsPerPage: number;
    totalItems: number;

    constructor(private sessionService: SessionService) {

    }

    show(screen: any) {
        this.screen = screen;
        this.items = screen.items;
        this.categories = screen.categories;
        this.maxItemsPerPage = screen.maxItemsPerPage;
        this.totalItems = screen.itemTotalCount;
    }

    public onCategorySelected(category: IMenuItem, event?: any) {
        this.sessionService.response = category.title;
        this.sessionService.onAction(category.action);
    }

    public onPageEvent(event?: PageEvent) {
        this.sessionService.response = event;
        this.sessionService.onAction('PageEvent');
    }
  }