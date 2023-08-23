package org.desinfector.corona;

@Deprecated
public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        announcer.announce("Get out");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Get in");
    }

    private void desinfect(Room room) {
        System.out.println("desinfecting...");
    }
}
