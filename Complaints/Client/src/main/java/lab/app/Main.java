package lab.app;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;

public class Main {
    public static void main(String[] args){
        Client client = ClientBuilder.newClient();
        getStatus(client);
        getAllComplaints(client);
        int complaintId = 3;
        getComplaintById(client, Long.valueOf(complaintId));
        String modifiedComplaint = "{\"id\": 3, \"complaintDate\": \"2021-04-24\", \"complaintText\": \"Repair fridge in room 311\", \"author\": \"Arthur McCoy\", \"status\": \"closed\"}";
        modifyComplaint(client, Long.valueOf(complaintId), modifiedComplaint);
        getComplaintById(client, Long.valueOf(complaintId));
        getOpenComplaints(client);
        client.close();
    }
    private static void getStatus(Client client) {
        String status = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/5/status")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println("Status: " + status);
    }

    private static void getAllComplaints(Client client) {
        String complaints = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("All complaints: " + complaints);
    }

    private static void getComplaintById(Client client, Long id){
        String complaint = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Complaint: " + complaint);
    }

    private static void modifyComplaint(Client client, Long id, String modifiedComplaint){
        String modifyComplaint = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/"+id)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(modifiedComplaint), String.class);

        System.out.println("Complaint modification");
    }

    private static void getOpenComplaints(Client client) {
        String openComplaints = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Open complaints: " + openComplaints);
    }
    }
