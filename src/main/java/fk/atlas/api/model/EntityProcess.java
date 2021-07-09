package fk.atlas.api.model;

import java.util.List;

public class ProcessInstanceToDB {
    enum inpOutpType
    {
        rdbms_instance, rdbms_db, rdbms_table,rdbms_column;
    }
    enum entityType
    {
        instance, db, table;
    }
    public static class entity_rdbms_process_instanceToDB {
        public List<attributes_rdbms_instanceToDB> entities;
    }
    public static class attributes_rdbms_instanceToDB {
        public attributes_field_rdbms_process_instanceToDB attributes;
        public String typeName = "Process";
    }

    public static class attributes_field_rdbms_process_instanceToDB {
        public String qualifiedName;
        public String name;
        public String description;
        public String owner;
        public String ownerName;
        public String comment;
        public String contact_info;
        public String type;
        public String createTime;
        public String updateTime;
    }
    public static class entity{
        public String guid;
        public String typeName;
    }
}
