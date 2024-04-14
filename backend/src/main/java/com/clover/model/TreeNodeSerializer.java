package com.clover.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class TreeNodeSerializer extends StdSerializer<TreeNode> {

    public TreeNodeSerializer() {
        this(null);
    }

    public TreeNodeSerializer(Class<TreeNode> t) {
        super(t);
    }

    @Override
    public void serialize(TreeNode value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("value", value.getValue());
        gen.writeNumberField("height", value.getHeight());
        gen.writeFieldName("left");
        if (value.getLeft() == null) {
            gen.writeNull();
        } else {
            serialize(value.getLeft(), gen, provider);
        }
        gen.writeFieldName("right");
        if (value.getRight() == null) {
            gen.writeNull();
        } else {
            serialize(value.getRight(), gen, provider);
        }
        gen.writeEndObject();
    }
}