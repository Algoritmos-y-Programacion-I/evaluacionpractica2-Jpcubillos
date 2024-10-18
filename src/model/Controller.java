package model;

public class Controller {

    private Project proyecto;
    private Pillar pilar;
    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];

    }


    public void precargaPilares(){

        Pillar biodiversidad = new Pillar ( "Biodiversidad");
        pillars[0] = biodiversidad; 

        Pillar agua = new Pillar ( "Agua");
        pillars[1] = agua; 

        Pillar tratamiento = new Pillar ( "Tratamiento de basuras");
        pillars[2] = tratamiento; 
        
        Pillar ambiente = new Pillar ( "Ambiente");
        pillars[3] = ambiente; 

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {
        
        Project nuevo_proyecto= new Project(id, name, description, status);

        switch (pillarType) {

            case 1:
                pilar = pillars[0];
                pilar.registerProject(nuevo_proyecto);
                break;

            case 2:
                pilar = pillars[1];
                pilar.registerProject(nuevo_proyecto);
                break;

            case 3:
                pilar = pillars[2];
                pilar.registerProject(nuevo_proyecto);
                break;

            case 4:
                pilar = pillars[3];
                pilar.registerProject(nuevo_proyecto);
                break;

        }
        
        return true;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {

        String query = "";  

        switch (pillarType) {

            case 1:
                pilar = pillars[0];
                query = pilar.toString();
                break;

            case 2:
                pilar = pillars[1];
                query = pilar.toString();
                break;

            case 3:
                pilar = pillars[2];
                query = pilar.toString();
                break;

            case 4:
                pilar = pillars[3];
                query = pilar.toString();
                break;

        }

        return query;

	}


}