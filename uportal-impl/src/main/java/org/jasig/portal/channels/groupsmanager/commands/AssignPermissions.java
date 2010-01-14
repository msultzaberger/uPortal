/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package  org.jasig.portal.channels.groupsmanager.commands;

import java.util.Enumeration;

import org.jasig.portal.ChannelRuntimeData;
import org.jasig.portal.channels.groupsmanager.CGroupsManagerSessionData;
import org.jasig.portal.channels.groupsmanager.GroupsManagerConstants;
import org.jasig.portal.channels.groupsmanager.GroupsManagerXML;
import org.jasig.portal.channels.permissionsmanager.CPermissionsManagerServantFactory;
import org.jasig.portal.groups.IEntityGroup;

/**
 * A Groups Manager command to instantiate a permissions manager servant
 *
 * @author Alex Vigdor
 * @version $Revision$
 * @deprecated All IChannel implementations should be migrated to portlets
 */
@Deprecated
public class AssignPermissions extends GroupsManagerCommand implements GroupsManagerConstants{

  public AssignPermissions() {
  }

   /**
    * put your documentation comment here
    * @param sessionData
    * @throws Exception
    */
   public void execute(CGroupsManagerSessionData sessionData) throws Exception{
      ChannelRuntimeData slaveRD = sessionData.runtimeData;
      String[] tgts = new String[1];
      String[] acts = null;
      IEntityGroup g = (IEntityGroup) GroupsManagerXML.retrieveGroupMemberForElementId(this.getXmlDoc(sessionData), this.getCommandArg(sessionData.runtimeData));
      tgts[0] = g.getKey();
      if (g.isEditable()){
         acts = sessionData.permissible.getActivityTokens();
      }
      else{
        acts = new String[] {VIEW_PERMISSION, SELECT_PERMISSION, ASSIGN_PERMISSION};
      }
      sessionData.servantChannel = CPermissionsManagerServantFactory.getPermissionsServant(sessionData.permissible,
            sessionData.staticData, null, acts, tgts);
      slaveRD = (ChannelRuntimeData)sessionData.runtimeData.clone();
      Enumeration srd = slaveRD.keys();
      while (srd.hasMoreElements()) {
         slaveRD.remove(srd.nextElement());
      }
      sessionData.runtimeData = slaveRD;
   }
}