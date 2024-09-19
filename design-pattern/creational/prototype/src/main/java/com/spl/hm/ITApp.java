package com.spl.hm;

public class ITApp {
    public static void main(String[] args) {
        Computer computer1 = new Computer("macOS Big Sur", "Slack", "Kaspersky", "Chrome v91", "Skype");
        Computer computer2 = computer1.clone();
        computer2.setOthers("Jira, OpenShift, SourceTree, IntelliJ IDEA");

        System.out.println(computer1);
        System.out.println(computer2);

        //Computer{os='macOS Big Sur', office='Slack', antivirus='Kaspersky', browser='Chrome v91', others='Skype'}
        //Computer{os='macOS Big Sur', office='Slack', antivirus='Kaspersky', browser='Chrome v91', others='Jira, OpenShift, SourceTree, IntelliJ IDEA'}
    }
}
