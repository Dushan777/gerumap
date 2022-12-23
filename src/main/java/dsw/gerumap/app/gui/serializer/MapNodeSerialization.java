package dsw.gerumap.app.gui.serializer;

import com.google.gson.*;
import dsw.gerumap.app.mapRepository.composite.MapNode;

import java.lang.reflect.Type;

public class MapNodeSerialization implements JsonDeserializer<MapNode>, JsonSerializer<MapNode> {


    @Override
    public MapNode deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        System.out.println(jsonObject);
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");
        System.out.println("element = " + element);


        try {
            return jsonDeserializationContext.deserialize(element, Class.forName("dsw.gerumap.app.mapRepository.implementation." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + cnfe);
        }
    }

    @Override
    public JsonElement serialize(MapNode mapNode, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(mapNode.getClass().getSimpleName()));
        result.add("properties", jsonSerializationContext.serialize(mapNode, mapNode.getClass()));

        return result;
    }
}
