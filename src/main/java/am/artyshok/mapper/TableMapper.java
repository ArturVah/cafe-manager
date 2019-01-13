package am.artyshok.mapper;

import am.artyshok.dto.Table;
import am.artyshok.entity.TableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface TableMapper {

    TableEntity map(Table table);

    Table map(TableEntity tableEntity);

    List<Table> map(List<TableEntity> tableEntities);

    List<TableEntity> mapTablesToTableEntities(List<Table> tables);
}
