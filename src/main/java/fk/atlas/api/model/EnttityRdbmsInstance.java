package fk.atlas.api;

public class EnttityRdbmsInstance {
    public static class attributes_rdbms_instance {
        public attributes_field_rdbms_instance attributes;
        public String typeName = "rdbms_instance";
        public String status = "ACTIVE";
    }

    public static class attributes_field_rdbms_instance {
        public String qualifiedName;
        public String name;
        public String rdbms_type;
        public String platform;
        public String hostname;
        public String port;
        public String protocol;
        public String contact_info;
        public String description;
        public String owner;
        public String ownerName;
    }

    public static class entity_rdbms_instance {
        public attributes_rdbms_instance entity;
    }
}
