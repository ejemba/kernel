/**
 * Copyright (C) 2014 Kametic <epo.jemba@kametic.com>
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
package io.nuun.kernel.tests.ut.assertor.dsl.wildcard;

/**
 *
 * 
 * @author epo.jemba{@literal @}kametic.com
 * @author pierre.thirouin{@literal @}gmail.com
 *
 */
public interface Wildcard
{
	 
    
    public enum All implements Wildcard{
    	ANY
    }
    
    public enum TypeLiteral implements WildcardTypeLiteral{
    	ANY_TYPE_LITERAL
    }
    public enum Key implements WildcardKey{
    	ANY_KEY
    }
    public enum Class implements WildcardClass{
    	ANY_CLASS
    }
    public enum Object implements WildcardObject{
        ANY_OBJECT
    }
    public enum Annotation implements WildcardAnnotation{
        ANY_ANNOTATION
    }
    
    public enum Scope implements WildcardScope{
        ANY_ANNOTATION
    }
    

}