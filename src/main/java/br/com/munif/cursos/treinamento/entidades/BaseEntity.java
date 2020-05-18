package br.com.munif.cursos.treinamento.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.munif.cursos.treinamento.UIDHelper;

@MappedSuperclass
public class BaseEntity {
	
    @Id
    @Column(length = 100)
    protected String id;

    protected String importInfo;

    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date cd;

    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date ud;

    @JsonIgnore
    protected Boolean active;

    @Version
    private Integer version;

    public BaseEntity() {
        init();
    }

    private void init() {
        id = UIDHelper.getUID();
        importInfo = "new";
        cd = new Date();
        ud = new Date();
        active = true;
        version = null;
    }

}
