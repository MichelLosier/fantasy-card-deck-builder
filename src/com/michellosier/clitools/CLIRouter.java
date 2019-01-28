package com.michellosier.clitools;

import java.util.HashMap;

public class CLIRouter {

    private HashMap<String, EntityCLI> entityInterfaces;

    public CLIRouter(){
        this.entityInterfaces = new HashMap();
    }

    public void addInterface(EntityCLI entityCLI){
        entityInterfaces.put(entityCLI.getNamespace(), entityCLI);
    }

    public void routeCommand(CLICommand command){
        String entityNamespace = command.getEntity();
        if(entityNamespace.equals("router")){
            if(command.getAction().equals("usage")){
                this.printAllInterfaces();
                return;
            }
        }
        if(entityInterfaces.containsKey(entityNamespace)){
            EntityCLI entityInterface = entityInterfaces.get(entityNamespace);
            entityInterface.handleCommand(command);
        } else {
            System.out.printf("Entity namespace '%s' for command is not known", entityNamespace);
        }
    }

    public void printAllInterfaces(){
        System.out.println("Available Interfaces:\n");
        entityInterfaces.forEach((namespace, entityCLI) -> {
            System.out.printf("%s: %s\n", namespace, entityCLI.getDescription());
        });
    }
}
