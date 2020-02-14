package org.jumpmind.pos.core.screen;

import java.util.ArrayList;
import java.util.List;

import org.jumpmind.pos.core.template.SellTemplate;

public class ItemSearchResultsScreen extends PromptScreen {

    private static final long serialVersionUID = 1L;

    private List<SellItem> items = new ArrayList<>();

    public ItemSearchResultsScreen() {
        this.setScreenType(ScreenType.ItemSearchResults);
        this.setTemplate(new SellTemplate());
    }

    public List<SellItem> getItems() {
        return items;
    }

    public void setItems(List<SellItem> items) {
        this.items = items;
    }

}