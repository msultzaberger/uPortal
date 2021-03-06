/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portal.utils;

import java.util.Map;
import java.util.Properties;

/**
 * Populator that targets a Properties object 
 * 
 * @author Eric Dalquist
 */
public class PropertiesPopulator implements Populator<String, String> {
    private final Properties properties;
    
    public PropertiesPopulator() {
        this.properties = new Properties();
    }

    public PropertiesPopulator(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Populator<String, String> put(String k, String v) {
        this.properties.put(k, v);
        return this;
    }
    
    @Override
    public Populator<String, String> putAll(Map<? extends String, ? extends String> m) {
        this.properties.putAll(m);
        return this;
    }

    public Properties getProperties() {
        return properties;
    }
}