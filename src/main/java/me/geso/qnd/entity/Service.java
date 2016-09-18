package me.geso.qnd.entity;

import java.time.LocalDateTime;

public class Service {
    private Long serviceId;
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Service() {
    }

    public Long getServiceId() {
        return this.serviceId;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Service)) return false;
        final Service other = (Service) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$serviceId = this.getServiceId();
        final Object other$serviceId = other.getServiceId();
        if (this$serviceId == null ? other$serviceId != null : !this$serviceId.equals(other$serviceId)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        final Object this$updated = this.getUpdated();
        final Object other$updated = other.getUpdated();
        if (this$updated == null ? other$updated != null : !this$updated.equals(other$updated)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $serviceId = this.getServiceId();
        result = result * PRIME + ($serviceId == null ? 43 : $serviceId.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        final Object $updated = this.getUpdated();
        result = result * PRIME + ($updated == null ? 43 : $updated.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Service;
    }

    public String toString() {
        return "me.geso.qnd.entity.Service(serviceId=" + this.getServiceId() + ", name=" + this.getName() + ", created=" + this.getCreated() + ", updated=" + this.getUpdated() + ")";
    }
}
