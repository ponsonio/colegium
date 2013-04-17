package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("repositorioArchivosList")
public class RepositorioArchivosList extends EntityQuery<RepositorioArchivos>
{

    private static final String EJBQL = "select repositorioArchivos from RepositorioArchivos repositorioArchivos";

    private static final String[] RESTRICTIONS = {
        "lower(repositorioArchivos.url) like lower(concat(#{repositorioArchivosList.repositorioArchivos.url},'%'))",
    };

    private RepositorioArchivos repositorioArchivos = new RepositorioArchivos();

    public RepositorioArchivosList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public RepositorioArchivos getRepositorioArchivos()
    {
        return repositorioArchivos;
    }
}
