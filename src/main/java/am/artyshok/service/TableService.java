package am.artyshok.service;

import am.artyshok.dto.Table;
import am.artyshok.entity.TableEntity;
import am.artyshok.entity.UserEntity;
import am.artyshok.mapper.TableMapper;
import am.artyshok.repository.TableRepository;
import am.artyshok.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private final TableMapper tableMapper;

    private final TableRepository tableRepository;
    private final UserRepository userRepository;

    public TableService(TableMapper tableMapper, TableRepository tableRepository, UserRepository userRepository) {
        this.tableMapper = tableMapper;
        this.tableRepository = tableRepository;
        this.userRepository = userRepository;
    }

    public Table create(Table table) {
        TableEntity newTableEntity = tableRepository.save(tableMapper.map(table));
        return tableMapper.map(newTableEntity);

    }

    public void attachWaiterToTable(Long waiterId, Long tableId) {
        TableEntity tableEntity = tableRepository.getById(tableId);

        UserEntity userEntity = userRepository
                .findById(waiterId)
                .orElseThrow(IllegalArgumentException::new);


        tableEntity.setWaiter(userEntity);

        tableRepository.save(tableEntity);
    }

    public List<Table> getTablesAssignedTo(Long waiterId) {
        UserEntity userEntity = userRepository
                .findById(waiterId)
                .orElseThrow(IllegalArgumentException::new);

        List<TableEntity> tableEntities = tableRepository.getByWaiter(userEntity);
        return tableMapper.map(tableEntities);
    }
}
