/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author <a href="http://community.jboss.org/people/LightGuard">Jason Porter</a>
 */
package org.jboss.arquillian.container.glassfish.remote_3_1;

import org.jboss.arquillian.container.spi.ConfigurationException;
import org.jboss.arquillian.container.spi.client.container.ContainerConfiguration;
import org.jboss.arquillian.container.spi.client.deployment.Validate;

public class GlassFishRestConfiguration implements ContainerConfiguration {

    /**
     * Glassfish Admin Console port.
     * Used to build the URL for the REST request.
     */
    private int remoteServerAdminPort = 4848;
    
    /**
     * Glassfish address.
     * Used to build the URL for the REST request.
     */
    private String remoteServerAddress = "localhost";
    
    /**
     * Flag indicating the administration url uses a secure connection.
     * Used to build the URL for the REST request.
     */
    private boolean remoteServerAdminHttps = false;
    
    /**
     * Flag indicating application urls use secure connections.
     * Used to build the URL for the REST request.
     */
    private boolean remoteServerHttps = false;
    
    /**
     * Http port for application urls.
     * Used to build the URL for the REST request.
     */
    private int remoteServerHttpPort = 8080;
    
    /**
     * Flag indicating the remote server requires an admin user and password. 
     */
    private boolean remoteServerAuthorisation = false;
    
    /**
     * Authorised admin user in the remote glassfish admin realm
     */
    private String remoteServerAdminUser;

    /**
     * Authorised admin user password
     */
    private String remoteServerAdminPassword;

    public String getRemoteServerAddress() {
        return remoteServerAddress;
    }

    public void setRemoteServerAddress(String remoteServerAddress) {
        this.remoteServerAddress = remoteServerAddress;
    }

    public int getRemoteServerAdminPort() {
        return remoteServerAdminPort;
    }

    public void setRemoteServerAdminPort(int remoteServerAdminPort) {
        this.remoteServerAdminPort = remoteServerAdminPort;
    }

    public boolean isRemoteServerAdminHttps() {
        return remoteServerAdminHttps;
    }

    public void setRemoteServerAdminHttps(boolean remoteServerAdminHttps) {
        this.remoteServerAdminHttps = remoteServerAdminHttps;
    }

    public int getRemoteServerHttpPort() {
        return remoteServerHttpPort;
    }

    public void setRemoteServerHttpPort(int remoteServerHttpPort) {
        this.remoteServerHttpPort = remoteServerHttpPort;
    }

    public boolean isRemoteServerHttps() {
        return remoteServerHttps;
    }

    public void setRemoteServerHttps(boolean remoteServerHttps) {
        this.remoteServerHttps = remoteServerHttps;
    }

    public boolean isRemoteServerAuthorisation() {
        return remoteServerAuthorisation;
    }

    public void setRemoteServerAuthorisation(boolean remoteServerAuthorisation) {
        this.remoteServerAuthorisation = remoteServerAuthorisation;
    }

    public String getRemoteServerAdminUser() {
        return remoteServerAdminUser;
    }

    public void setRemoteServerAdminUser(String remoteServerAdminUser) {
        this.setRemoteServerAuthorisation(true);
        this.remoteServerAdminUser = remoteServerAdminUser;
    }

    public String getRemoteServerAdminPassword() {
        return remoteServerAdminPassword;
    }

    public void setRemoteServerAdminPassword(String remoteServerAdminPassword) {
        this.remoteServerAdminPassword = remoteServerAdminPassword;
    }

    /**
     * Validates if current configuration is valid, that is if all required
     * properties are set and have correct values
     */
    public void validate() throws ConfigurationException {
       if(isRemoteServerAuthorisation())
       {
          Validate.notNull(getRemoteServerAdminUser(), "remoteServerAdminUser must be specified to use remoteServerAuthorisation");
          Validate.notNull(getRemoteServerAdminPassword(), "remoteServerAdminPassword must be specified to use remoteServerAuthorisation");
       }
    }
}
