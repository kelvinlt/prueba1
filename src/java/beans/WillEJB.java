/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Ruler;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author x2382383c
 */
@Stateless
public class WillEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public boolean insertarUsuario(Usuario t) {
        if (!existeUsuario(t)) {
            EntityManager em = emf.createEntityManager();
            em.persist(t);
            em.close();
            return true;
        }
        return false;
    }

    public boolean existeUsuario(Usuario t) {
        EntityManager em = emf.createEntityManager();
        Usuario usuarioEncontrado = em.find(Usuario.class, t.getNombre());
        em.close();
        return usuarioEncontrado != null;
    }

    public List<Ruler> selectRuler() {
        List<Ruler> listaRuler = emf.createEntityManager().createNamedQuery("Ruler.findAll").getResultList();
        List<Ruler> ruler = new ArrayList<>();
        for (Ruler rulerAhora : listaRuler) {
            ruler.add(rulerAhora);
        }
        return ruler;
    }

    public List<Usuario> selectUsuario() {
        List<Usuario> listaUsuario = emf.createEntityManager().createNamedQuery("Usuario.findAll").getResultList();
        List<Usuario> usuario = new ArrayList<>();
        for (Usuario usuarioAhora : listaUsuario) {
            usuario.add(usuarioAhora);
        }
        return usuario;
    }
}
