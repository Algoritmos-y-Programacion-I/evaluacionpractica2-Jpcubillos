package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);
        control.precargaPilares();

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {
    reader.nextLine();
    boolean salir = false;
    int type_final=0;
    
    while(!salir){
    System.out.println("Digite el tipo de pilar (1) Biodiversidad / (2) Agua / (3) Tratamiento de basuras / (4) Ambiente");
    int pillarType = reader.nextInt(); 
    
    if ((pillarType == 1) || (pillarType == 2) || (pillarType == 3) || (pillarType == 4)){
        salir=true;
        type_final=pillarType;
        break;   
        
    }else{
    System.out.println("Error, verifique el pilar.");
    }
    }

    reader.nextLine();
    
    System.out.println("Digite el id del pilar");
    String idPilar = reader.nextLine();

    System.out.println("Digite el nombre del proyecto");
    String name = reader.nextLine();

    System.out.println("Digite la descripcion del proyecto");
    String description = reader.nextLine(); 

    System.out.println("El proyecto esta activo? : (true / false)");
    boolean status = reader.nextBoolean(); 

    boolean resultado = control.registerProjectInPillar(type_final, idPilar, name, description, status);

    if(resultado){
        System.out.println("Proyecto registrado exitosamente");
    }else{
        System.out.println("Error memoria llena!");
    }

    }

    
    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {
    
    boolean salir = false;
    int type_final=0;
    
    while(!salir){
    System.out.println("Digite el tipo de pilar que desea consultar (1) Biodiversidad / (2) Agua / (3) Tratamiento de basuras / (4) Ambiente");
    int pillarType = reader.nextInt(); 
    
    if ((pillarType == 1) || (pillarType == 2) || (pillarType == 3) || (pillarType == 4)){
        salir=true;
        type_final=pillarType;
        break;   
        
    }else{
    System.out.println("Error, verifique el pilar.");
    }
    }

    System.out.println(control.queryProjectsByPillar(type_final));

    }

}