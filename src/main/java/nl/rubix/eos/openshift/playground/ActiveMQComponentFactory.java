/*
 * Copyright 2005-2015 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package nl.rubix.eos.openshift.playground;

import io.fabric8.annotations.Factory;
import io.fabric8.annotations.ServiceName;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.PropertyInject;

public class ActiveMQComponentFactory {

	@PropertyInject(value = "env:AMQ_USER")
	String mq_username;

	@PropertyInject(value = "env:AMQ_PASSWORD")
	String mq_password;

    @Factory
    @ServiceName
    public ActiveMQComponent create(@ServiceName ActiveMQConnectionFactory factory) {
        ActiveMQComponent component = new ActiveMQComponent();
        component.setUserName(mq_username);
        component.setPassword(mq_password);
        component.setConnectionFactory(factory);
        return component;
    }

    /*
    @Factory
    @ServiceName
    public ActiveMQComponent create(@ServiceName String url, @Configuration ActiveMQConfig config) {
        ActiveMQComponent component = new ActiveMQComponent();
        component.setBrokerURL(url);
        component.setConnectionFactory(new ActiveMQConnectionFactory(url));
        return component;
    }*/

}
