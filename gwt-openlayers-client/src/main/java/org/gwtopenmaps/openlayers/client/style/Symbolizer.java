/**
 *
 *   Copyright 2013 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 * Base class representing a symbolizer used for feature rendering
 *
 */
public class Symbolizer extends JSObjectWrapper
{

    protected Symbolizer(JSObject jsObject)
    {
        super(jsObject);
    }

    public void setZIndex(int zIndex)
    {
        SymbolizerImpl.setZIndex(this.getJSObject(), zIndex);
    }

    /**
     * Default is 0.
     * @return
     */
    public int getZIndex()
    {
        return SymbolizerImpl.getZIndex(this.getJSObject());
    }
}
