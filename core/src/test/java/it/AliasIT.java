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
package it;

import io.nuun.kernel.api.Kernel;
import io.nuun.kernel.api.plugin.InitState;
import io.nuun.kernel.api.plugin.context.InitContext;
import io.nuun.kernel.api.plugin.request.KernelParamsRequest;
import io.nuun.kernel.core.AbstractPlugin;
import io.nuun.kernel.core.internal.Fixture;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pierre THIROUIN (pierre.thirouin@ext.inetpsa.com)
 */
public class AliasIT
{
    @Test
    public void testAliases() throws Exception
    {
        Kernel kernel = Fixture.startKernel(Fixture.config()
                .param("alias1", "val1")
                .param("alias2", "val2")
                .addPlugin(AliasProviderPlugin.class)
                .addPlugin(AliasUserPlugin.class)
        );

        AliasProviderPlugin aliasProvider = (AliasProviderPlugin) kernel.plugins().get("alias-provider");
        Assertions.assertThat(aliasProvider.param1).isEqualTo("val1");
        Assertions.assertThat(aliasProvider.alias1).isEqualTo("val1");

        AliasUserPlugin aliasUser = (AliasUserPlugin) kernel.plugins().get("alias-user");
        Assertions.assertThat(aliasUser.param2).isEqualTo("val2");
        Assertions.assertThat(aliasUser.alias2).isEqualTo("val2");
    }

    public static class AliasProviderPlugin extends AbstractPlugin
    {
        String param1;
        String alias1;

        @Override
        public String name()
        {
            return "alias-provider";
        }

        @Override
        public Collection<KernelParamsRequest> kernelParamsRequests()
        {
            return kernelParamsRequestBuilder().mandatory("param1").build();
        }

        @Override
        public Map<String, String> kernelParametersAliases()
        {
            Map<String, String> aliases = new HashMap<>();
            aliases.put("alias1", "param1");
            aliases.put("alias2", "param2");
            return aliases;
        }

        @Override
        public InitState init(InitContext initContext)
        {
            param1 = initContext.kernelParam("param1");
            alias1 = initContext.kernelParam("alias1");
            return InitState.INITIALIZED;
        }
    }

    public static class AliasUserPlugin extends AbstractPlugin
    {
        String param2;
        String alias2;

        @Override
        public String name()
        {
            return "alias-user";
        }

        @Override
        public Collection<KernelParamsRequest> kernelParamsRequests()
        {
            return kernelParamsRequestBuilder().mandatory("param2").build();
        }

        @Override
        public InitState init(InitContext initContext)
        {
            param2 = initContext.kernelParam("param2");
            alias2 = initContext.kernelParam("alias2");
            return InitState.INITIALIZED;
        }
    }
}
