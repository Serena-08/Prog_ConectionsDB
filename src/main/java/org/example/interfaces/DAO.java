package org.example.interfaces;


import org.example.entities.Cliente;

import java.util.List;

public interface DAO <O,K> {

  // O objeto, K key, calve primaria
  /*
  insert
  update
  delete
  getAll
  getById
  exist
   */

  public List<O> getAll();
  public void insert(O objeto);
  public void update(O objeto);
  public void delete(K id);
  public Cliente getById(K id);
  public boolean existsById(K id);

}
