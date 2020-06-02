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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImportInfo() {
		return importInfo;
	}

	public void setImportInfo(String importInfo) {
		this.importInfo = importInfo;
	}

	public Date getCd() {
		return cd;
	}

	public void setCd(Date cd) {
		this.cd = cd;
	}

	public Date getUd() {
		return ud;
	}

	public void setUd(Date ud) {
		this.ud = ud;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
    
    

}
