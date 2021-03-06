package org.domain.colegium.entity;
// Generated Mar 13, 2012 10:24:56 AM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * LibretaNotasFinalesCurso generated by hbm2java
 */
@Entity
@Table(name="libreta_notas_finales_curso"
)
public class LibretaNotasFinalesCurso  implements java.io.Serializable {


     private long id;
     private Curso curso;
     private LibretaNotas libretaNotas;
     private PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso;
     private BigDecimal nota;

    public LibretaNotasFinalesCurso() {
    }

    public LibretaNotasFinalesCurso(long id, Curso curso, LibretaNotas libretaNotas, PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso, BigDecimal nota) {
       this.id = id;
       this.curso = curso;
       this.libretaNotas = libretaNotas;
       this.periodoAcademicoSeccionCurso = periodoAcademicoSeccionCurso;
       this.nota = nota;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_curso", nullable=false)
    @NotNull
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_libreta_notas", nullable=false)
    @NotNull
    public LibretaNotas getLibretaNotas() {
        return this.libretaNotas;
    }
    
    public void setLibretaNotas(LibretaNotas libretaNotas) {
        this.libretaNotas = libretaNotas;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_periodo_academico_seccion_curso", nullable=false)
    @NotNull
    public PeriodoAcademicoSeccionCurso getPeriodoAcademicoSeccionCurso() {
        return this.periodoAcademicoSeccionCurso;
    }
    
    public void setPeriodoAcademicoSeccionCurso(PeriodoAcademicoSeccionCurso periodoAcademicoSeccionCurso) {
        this.periodoAcademicoSeccionCurso = periodoAcademicoSeccionCurso;
    }

    
    @Column(name="nota", nullable=false, precision=4)
    @NotNull
    public BigDecimal getNota() {
        return this.nota;
    }
    
    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }




}


