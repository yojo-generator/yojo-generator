package ru.yojo.codegen;

import org.apache.commons.lang3.BooleanUtils;
import ru.yojo.codegen.domain.LombokProperties;
import ru.yojo.codegen.generator.YojoGenerator;
import ru.yojo.codegen.mapper.SchemaMapper;

public class YojoCLI {
    public static void main(String[] args) {
        if (args.length != 0) {
            YojoGenerator yojoGenerator = new YojoGenerator(new SchemaMapper());
            boolean lombokEnabled = BooleanUtils.isTrue(Boolean.valueOf(args[2]));
            boolean allArgsConstr = false;
            boolean accessors = false;
            if (lombokEnabled) {
                allArgsConstr = BooleanUtils.isTrue(Boolean.valueOf(args[3]));
                accessors = BooleanUtils.isTrue(Boolean.valueOf(args[4]));
            }
            yojoGenerator.generate(args[0], args[1], new LombokProperties(lombokEnabled, allArgsConstr, accessors));
        } else {
            throw new RuntimeException("Arguments not found: Expected arguments: filePath, outputDirectory, lombokProperties - 3 boolean values(enable, allArgsConstr, accessors");
        }
    }
}