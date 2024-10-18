package model;

public class Pillar {

    private String name;
    private Project[] projects;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50];
    }

    /**
     * Descripcion: Añade un nuevo Project al arreglo projects
     * pre: El arreglo projects debe estar inicializado
     * pos: El arreglo projects queda modificado con el nuevo Project
     * agregado
     * 
     * @param newProject Project El Project que se va a añadir
     * @return boolean true si se logra añadir el Project, false en caso
     *         contrario
     */
    public boolean registerProject(Project newProject) {

		for (int i=0; i<projects.length;i++){
			if (projects[i]==null){
				projects[i] = newProject;
				return true;
			}
		}


        return false;
    }

    /**
     * Descripcion: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pillar
     * pre: El arreglo projects debe estar inicializado
     * 
     */
    public String getProjectList() {

        String list = "Lista de proyectos: ";
        boolean valido = false;

        if (projects == null){
            list = "No hay proyectos registrados";
        }else{
            for (int i = 0; i < projects.length; i++) {
                if (projects[i] != null) {
                    list += " "+projects[i].toString() + "\n";
                    valido = true;
                }
            }

            if (valido == false) {
                list = "No hay proyectos registrados";
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return "Pillar nombre= " + this.name + " " + getProjectList() ;

    }



}
