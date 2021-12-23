package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import track.individual.read4share.config.GlobalConstants;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.dto.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvOverviewServiceImpl implements AdvOverviewService {

    private final AdvRepo advRepo;
    private final Converter converter;
    private final CategoryService catService;

    @Override
    public List<AdvOverviewResponse> getLatest(int size) {
        return converter.toAdvOverviewResponse(advRepo.findLatest(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getBestRating(int size) {
        return converter.toAdvOverviewResponse(advRepo.findBestRating(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getFree(int size) {
        return converter.toAdvOverviewResponse(advRepo.findFree(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getFreeDel(int size) {
        return converter.toAdvOverviewResponse(advRepo.findFreeDel(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getAsNew(int size) {
        return converter.toAdvOverviewResponse(advRepo.findAsNew(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getByCategoryId(Long id, int page, int size) {
        // Check whether the category id is valid
        if (!catService.isValid(id))
            throw new ItemNotFoundException("Category with specified id not found");
        // Get the advertisements list
        return converter.toAdvOverviewResponse(advRepo.findByCatId(
                id, PageRequest.of(page, this.validateRecordsNumber(size))));
    }


    /**
     * Check whether the size parameter respects the maximum allowed
     * @param size Value to be validated
     * @return Validated int value
     */
    private int validateRecordsNumber(int size) {
        return Math.min(size, GlobalConstants.maxRecordsAdvOverview);
    }
}