/**
 * Copyright (C) 2013-2014 Kametic <epo.jemba@kametic.com>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * or any later version
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.nuun.kernel.core.internal;

import io.nuun.kernel.api.config.ClasspathScanMode;
import io.nuun.kernel.core.internal.concerns.ConcernTest;
import io.nuun.kernel.core.internal.concerns.sample.BugPlugin;
import io.nuun.kernel.core.internal.concerns.sample.CachePlugin;
import io.nuun.kernel.core.internal.concerns.sample.LogPlugin;
import io.nuun.kernel.core.internal.concerns.sample.SecurityPlugin;
import io.nuun.kernel.core.internal.injection.ClassInstaller;
import io.nuun.kernel.core.internal.injection.KernelGuiceModuleInternal;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class InternalKernelModuleTest
{
    private KernelGuiceModuleInternal underTest;

    @Before
    public void init()
    {
        RequestHandler requestHandler = new RequestHandler(new HashMap<String, String>(), ClasspathScanMode.NOMINAL);
        underTest = new KernelGuiceModuleInternal(requestHandler);
    }

    @Test
    public void computeOrder_should_works()
    {
        Assertions.assertThat(new ClassInstaller(SecurityPlugin.Module.class).order()).isEqualTo(12884901888L);
        Assertions.assertThat(new ClassInstaller(LogPlugin.Module.class).order()).isEqualTo(-4294967296L);
        Assertions.assertThat(new ClassInstaller(CachePlugin.Module.class).order()).isEqualTo(12884901886L);
        Assertions.assertThat(new ClassInstaller(ConcernTest.Module.class).order()).isEqualTo(0);
        Assertions.assertThat(new ClassInstaller(BugPlugin.Module.class).order()).isEqualTo(15032385535L);
    }
}
