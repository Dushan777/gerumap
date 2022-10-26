package dsw.gerumap.app.mapRepository;

import dsw.gerumap.app.core.MapRepository;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class Repository implements MapRepository {

    private ProjectExplorer projectExplorer;

    @Override
    public void initialise() {
        // da li treba ovde da se inicijalizuju element, mindMap, ... ili treba nesto sa MapNode
        // da preimenujemo klasu?

    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        // je li ovo samo kao getter ili treba nesto drugo da radi
        return projectExplorer;
    }
}
