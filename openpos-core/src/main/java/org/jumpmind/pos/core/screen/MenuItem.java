/**
 * Licensed to JumpMind Inc under one or more contributor
 * license agreements.  See the NOTICE file distributed
 * with this work for additional information regarding
 * copyright ownership.  JumpMind Inc licenses this file
 * to you under the GNU General Public License, version 3.0 (GPLv3)
 * (the "License"); you may not use this file except in compliance
 * with the License.
 *
 * You should have received a copy of the GNU General Public License,
 * version 3.0 (GPLv3) along with this library; if not, see
 * <http://www.gnu.org/licenses/>.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jumpmind.pos.core.screen;

import java.io.Serializable;
import java.util.List;

public class MenuItem implements IUIAction, Serializable {

    private static final long serialVersionUID = 1L;
    
    private String action;
    private String title;
    private String icon;
    private boolean enabled = true;
    private ConfirmationDialog confirmationDialog;
    private List<MenuItem> children;
    private boolean sensitive;
    private String buttonSize;
    private String fontSize;
    private boolean active = false;
    private String keybind;

    public final static String FONT_SIZE_XS = "text-xs";
    public final static String FONT_SIZE_SM = "text-sm";
    public final static String FONT_SIZE_MD = "text-md";
    public final static String FONT_SIZE_LG = "text-lg";
    public final static String FONT_SIZE_XL = "text-xl";

    public final static String BUTTON_SIZE_XS = "menuItem-xs";
    public final static String BUTTON_SIZE_SM = "menuItem-sm";
    public final static String BUTTON_SIZE_MD = "menuItem-md";
    public final static String BUTTON_SIZE_LG = "menuItem-lg";
    public final static String BUTTON_SIZE_XL = "menuItem-xl";
    
    public MenuItem() {
    }
    
    
    public MenuItem(String action) {
        this.action = action;    
    }

    public MenuItem(String action, String title) {
        this.action = action;
        this.title = title;
    }

    public MenuItem(String action, String title, String icon) {
        this(action, title);
        this.icon = icon;
    }
    
    public MenuItem(String action, String title, String icon, boolean active) {
        this(action, title);
        this.icon = icon;
        this.active = active;
    }
    
    
    public MenuItem(String action, String title, IIcon icon) {
        this(action, title, icon.getName());
    }
    
    public MenuItem(String action, String title, String icon, String confirmationMessage) {
        this(action, title, icon);
        if (confirmationMessage != null) {
            this.confirmationDialog = new ConfirmationDialog();
            this.confirmationDialog.setMessage(confirmationMessage);
        }
    }
    
    public MenuItem(String action, String title, String icon, ConfirmationDialog confirmationDialog) {
    	this(action, title, icon );
    	this.confirmationDialog = confirmationDialog;
    }
    
    public MenuItem(String title, String action, boolean enabled) {
        super();
        this.action = action;
        this.title = title;
        this.enabled = enabled;
    }
    
    public MenuItem(String title, String action, boolean enabled, boolean sensitive) {
        super();
        this.action = action;
        this.title = title;
        this.enabled = enabled;
        this.sensitive = sensitive;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    public MenuItem action(String action) {
        this.setAction(action);
        return this;
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public MenuItem title(String title) {
        this.setTitle(title);
        return this;
    }
    
    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MenuItem icon(String icon) {
        this.setIcon(icon);
        return this;
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    public MenuItem enabled(boolean enabled) {
        this.setEnabled(enabled);
        return this;
    }
    
    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }
    
    public List<MenuItem> getChildren() {
        return children;
    }
    
    public MenuItem children(List<MenuItem> children) {
        this.setChildren(children);
        return this;
    }
    
    public String getConfirmationMessage() {
    	if( this.confirmationDialog != null ) {
            return this.confirmationDialog.getMessage();
    	}
    	
    	return null;
    }
    
    public void setConfirmationMessage(String confirmationMessage) {
    	
    	if( this.confirmationDialog == null ) {
    		this.confirmationDialog = new ConfirmationDialog();
    	}
    	    	
        this.confirmationDialog.setMessage(confirmationMessage);
    }

    public MenuItem confirmationMessage(String confirmationMessage) {
        this.setConfirmationMessage(confirmationMessage);
        return this;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    public MenuItem sensitive(boolean sensitive) {
        this.setSensitive(sensitive);
        return this;
    }

    public String getButtonSize() {
        return buttonSize;
    }

    public void setButtonSize(String buttonSize) {
        this.buttonSize = buttonSize;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }


	public ConfirmationDialog getConfirmationDialog() {
		return confirmationDialog;
	}


	public void setConfirmationDialog(ConfirmationDialog confirmationDialog) {
		this.confirmationDialog = confirmationDialog;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


    public String getKeybind() {
        return keybind;
    }


    public void setKeybind(String keybind) {
        this.keybind = keybind;
    }
    
    public MenuItem keybind(String keybind) {
        this.setKeybind(keybind);
        return this;
    }
    
}