import java.util.*;

class NoAgentAvailableException extends Exception{
    public NoAgentAvailableException(String message){
        super(message);
    }
}

class Order{
    private String orderID;

    public Order(String orderId){
        this.orderID = orderId;
    }

    @Override
    public String toString(){ return orderID; }

}

class Agent{
    private String agentId;
    boolean isAvailable;

    public Agent(String agentId){
        this.agentId = agentId;
        this.isAvailable = true;
    }

    @Override
    public String toString(){ return agentId; }

}

class DeliveryService{
    private Queue<Order> orderQueue = new LinkedList<>();

    private List<Agent> agents = new ArrayList<>();

    private Map<Order, Agent> deliveries = new HashMap<>();

    public void addOrder(Order order){
        orderQueue.add(order);
    }

    public void addAgent(Agent agent){
        agents.add(agent);
    }

    public void assignOrder() throws NoAgentAvailableException{
        if(orderQueue.isEmpty()) return;

        Agent freeAgent = null;
        for(Agent agent : agents){
            if(agent.isAvailable){
                freeAgent = agent;
                break;
            }
        }

        if(freeAgent == null)
            throw new NoAgentAvailableException("No Agent Available");

        Order order = orderQueue.poll();
        freeAgent.isAvailable = false;
        deliveries.put(order, freeAgent);
    }

    public void viewDeliveries(){
        for(Map.Entry<Order, Agent> entry : deliveries.entrySet())
            System.out.println(entry.getKey() + " assigned to " + entry.getValue());
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();

        service.addAgent(new Agent("Agent 1"));
        service.addAgent(new Agent("Agent 2"));

        service.addOrder(new Order("Order 101"));
        service.addOrder(new Order("Order 102"));
        service.addOrder(new Order("Order 103"));

        try{
            service.assignOrder();
            service.assignOrder();
            service.assignOrder();
        }
        catch(NoAgentAvailableException e){
            System.out.println(e.getMessage());
        }

        service.viewDeliveries();
    }
}
