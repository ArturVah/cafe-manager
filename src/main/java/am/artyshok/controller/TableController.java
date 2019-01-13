package am.artyshok.controller;

import am.artyshok.dto.AttachRequest;
import am.artyshok.dto.Table;
import am.artyshok.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    /**
     * @param table to persist in database
     * @return Created table object
     */
    @PostMapping
    public ResponseEntity<?> registerTable(@RequestBody Table table) {
        Table savedTable = tableService.create(table);
        return ResponseEntity.ok(savedTable);
    }


    /**
     * @param tableId which must be updated
     * @param attach  request object
     * @return is everything passed ok
     */
    @PutMapping("/table/{tableId}")
    public ResponseEntity<?> assignWaiterToTable(@PathVariable Long tableId, @RequestBody AttachRequest attach) {
        tableService.attachWaiterToTable(attach.getWaiterId(), tableId);
        return ResponseEntity.ok().build();
    }

    /**
     * @param waiterId to find tables assigned to
     * @return  All tables that assigned to @waiterId
     */
    @GetMapping
    public ResponseEntity<?> getAllTablesAssignedTo(@RequestParam Long waiterId) {
        List<Table> tables = tableService.getTablesAssignedTo(waiterId);
        return ResponseEntity.ok(tables);
    }

}
