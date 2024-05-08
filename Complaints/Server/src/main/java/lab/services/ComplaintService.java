package lab.services;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lab.data.ComplaintRepository;
import lab.dto.ComplaintDTO;
import lab.entities.Complaint;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.util.List;
import java.lang.reflect.Type;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ComplaintService {

    @Inject
    private ComplaintRepository repository;
    @Transactional
    public void create(ComplaintDTO dto) {
        ModelMapper mapper = new ModelMapper();
        repository.create(mapper.map(dto, Complaint.class));
    }

    @Transactional
    public void edit(ComplaintDTO dto) {
        ModelMapper mapper = new ModelMapper();
        repository.edit(mapper.map(dto, Complaint.class));
    }

    @Transactional
    public void remove(ComplaintDTO dto) {
        repository.remove(repository.find(dto.getId()));
    }

    @Transactional
    public ComplaintDTO find(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(repository.find(id), ComplaintDTO.class);
    }

    @Transactional
    public List<ComplaintDTO> findAll(String status) {
        ModelMapper mapper = new ModelMapper();
        List<Complaint> entityList = repository.findAll(status);
        Type listType =
                new TypeToken<List<ComplaintDTO>>() {}.getType();
        List<ComplaintDTO> dtoList =
                mapper.map(entityList, listType);
        return dtoList;
    }



}
