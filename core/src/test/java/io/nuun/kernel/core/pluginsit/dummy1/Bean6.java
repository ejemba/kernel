/**
 * This file is part of Nuun IO Kernel Core.
 *
 * Nuun IO Kernel Core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Nuun IO Kernel Core is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Nuun IO Kernel Core.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.nuun.kernel.core.pluginsit.dummy1;

import javax.inject.Inject;


/**
 * @author Epo Jemba
 */
@MarkerSample4
public class Bean6
{

    @Inject
    @MarkerSample3
    private DummyService service;

    public Bean6()
    {
    }

    public String sayHi()
    {
        if (service != null)
        {
            return service.dummy();
        } else
        {
            return "no service";
        }
    }
}
