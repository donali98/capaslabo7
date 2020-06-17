package com.dona.labo7.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public",name = "estudiante")
public class  Estudiante {
    @Column(name = "id_estudiante")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codStudent;
    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max = 30, message = "El campo no debe tener mas de 30 caracteres")
    @Column(name = "nombre")
    private String name;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max = 50, message = "El campo no debe tener mas de 30 caracteres")
    @Column(name = "apellido")
    private String lastName;

    @NotNull(message = "El campo no debe estar vacio")
    @Min(value = 18, message = "No puede ser menor de 18")
    @Column(name = "edad")
    private Integer age;

    @Column(name = "estado")
    private Boolean state;

    public String getEstadoDelegate() {
        if(this.state == null) return "";
        else return this.state ? "Activo" : "Inactivo";
    }

    public Estudiante() {
    }

    public Integer getCodStudent() {
        return codStudent;
    }

    public void setCodStudent(Integer codStudent) {
        this.codStudent = codStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
