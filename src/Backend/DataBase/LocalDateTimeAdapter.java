/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DataBase;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Mnw Emile
 */
public class LocalDateTimeAdapter implements JsonDeserializer<LocalDateTime>, JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime t, Type type, JsonSerializationContext jsc) {
        return jsc.serialize(t.format(formatter));
    }

    @Override
    public LocalDateTime deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        return LocalDateTime.parse(je.getAsString(), formatter);
    }

}
