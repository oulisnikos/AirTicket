/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exetasimae2;

/**
 *
 * @author n.oulis
 */
public class Employee
{
  private String name;
  private String surname;
  private String misthos;
  private String eidiko;
  private int etos;
  private int orario;
  private int yper;

  public Employee(String name, String surname, String misthos, String eidiko, int etos, int orario)
  {
    this.name = name;
    this.surname = surname;
    this.misthos = misthos;
    this.eidiko = eidiko;
    this.etos = etos;
    this.orario = orario;
  }



  public Employee()
  {
    this.name = null;
    this.surname = null;
    this.etos = 0;
    this.misthos = null;
    this.eidiko = null;
    this.orario = 0;
    this.yper =0;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSurname()
  {
    return surname;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public int getEtos()
  {
    return etos;
  }

  public void setEtos(int etos)
  {
    this.etos = etos;
  }

  public String getMisthos()
  {
    return misthos;
  }

  public void setMisthos(String misthos)
  {
    this.misthos = misthos;
  }

  public String getEidiko()
  {
    return eidiko;
  }

  public void setEidiko(String eidiko)
  {
    this.eidiko = eidiko;
  }

  public int getOrario()
  {
    return orario;
  }

  public void setOrario(int orario)
  {
    this.orario = orario;
  }

  public int getYper()
  {
    return yper;
  }

  public void setYper(int yper)
  {
    this.yper = yper;
  }
  
  
  
  
  
}
