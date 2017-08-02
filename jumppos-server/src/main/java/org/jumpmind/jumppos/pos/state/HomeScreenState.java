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
package org.jumpmind.jumppos.pos.state;

import java.util.ArrayList;
import java.util.List;

import org.jumpmind.jumppos.core.flow.IState;
import org.jumpmind.jumppos.core.flow.IStateManager;
import org.jumpmind.jumppos.core.model.MenuItem;
import org.jumpmind.jumppos.core.model.Screen;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeScreenState implements IState {
    
    @Autowired
    IStateManager stateManager;
    
    @Override
    public void arrive() {
        stateManager.showScreen(buildMenu());
    }
    
    protected Screen buildMenu() {
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("Sell", "Sell", "http://server/icon"));
        menuItems.add(new MenuItem("ItemLookup", "Item Lookup", "http://server/icon"));
        Screen screen = new Screen(){};
        screen.setName("MainMenu");
        screen.put("menuItems", menuItems);
        return screen;
    }
}
