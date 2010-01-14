/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package org.jasig.portal.channels;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.portal.ChannelRuntimeData;
import org.jasig.portal.ChannelRuntimeProperties;
import org.jasig.portal.ChannelStaticData;
import org.jasig.portal.IChannel;
import org.jasig.portal.PortalEvent;
import org.jasig.portal.PortalException;
import org.xml.sax.ContentHandler;

/**
 * A base class from which channels implementing IChannel interface can be derived.
 * Use this only if you are familiar with IChannel interface.
 * @author Peter Kharchenko
 * @version $Revision$
 * @deprecated All IChannel implementations should be migrated to portlets
 */
@Deprecated
public abstract class BaseChannel implements IChannel {
    protected ChannelStaticData staticData;
    protected ChannelRuntimeData runtimeData;

    /**
     * A Commons Logging log instance which will log as the runtime class extending
     * this BaseChannel.  Channels extending BaseChannel can use this Log instance
     * rather than instantiating their own.
     */
    protected final Log log = LogFactory.getLog(getClass());

    public ChannelRuntimeProperties getRuntimeProperties() {
        return new ChannelRuntimeProperties();
    }

    public void receiveEvent(PortalEvent ev) {
    }

    public void setStaticData(ChannelStaticData sd) throws PortalException {
        this.staticData = sd;
    }

    public void setRuntimeData(ChannelRuntimeData rd) throws PortalException {
        this.runtimeData = rd;
    }

    public void renderXML(ContentHandler out) throws PortalException {
    }

    public String toString() {
        return "BaseChannel: staticData = [" + staticData + "] runtimeData = [" + runtimeData + "]";
    }
}
