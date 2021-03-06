package opera.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import opera.dto.request.PerformanceSessionRequestDto;
import opera.dto.response.PerformanceSessionResponseDto;
import opera.model.PerformanceSession;
import opera.service.PerformanceSessionService;
import opera.service.mapper.PerformanceSessionMapper;
import opera.util.DateTimePatternUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper movieSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public PerformanceSessionResponseDto add(@RequestBody @Valid
                                                         PerformanceSessionRequestDto requestDto) {
        PerformanceSession movieSession = performanceSessionMapper.mapToModel(requestDto);
        performanceSessionService.add(movieSession);
        return performanceSessionMapper.mapToDto(movieSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAll(@RequestParam Long movieId,
                                                @RequestParam
                                                @DateTimeFormat(pattern = DATE_PATTERN)
                                                        LocalDate date) {
        return performanceSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(performanceSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PerformanceSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody
                                          @Valid PerformanceSessionRequestDto requestDto) {
        PerformanceSession performanceSession = performanceSessionMapper.mapToModel(requestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
        return performanceSessionMapper.mapToDto(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
