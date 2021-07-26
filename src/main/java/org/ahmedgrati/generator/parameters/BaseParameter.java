package org.ahmedgrati.generator.parameters;

import picocli.CommandLine;

public class BaseParameter {
   @CommandLine.Option(names={"-g","--groupid"}, description = "Specify The Group ID Of The Project")
   private String groupId;

   public String getGroupId() {
      return groupId;
   }

   public void setGroupId(String groupId) {
      this.groupId = groupId;
   }
}
