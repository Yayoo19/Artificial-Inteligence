
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.Agent;

//Agente Emisor
public class First extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new OneShotBehaviour(){

            @Override
            public void action() {
                ACLMessage msg = new ACLMessage( ACLMessage.INFORM);
                msg.setContent("10");
                msg.addReceiver(new AID("second",AID.ISLOCALNAME));
                send(msg);
            }
        });
    }
}