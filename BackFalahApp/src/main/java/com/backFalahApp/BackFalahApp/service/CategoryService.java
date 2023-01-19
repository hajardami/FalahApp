package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.Dto.CategoryDto;
import com.backFalahApp.BackFalahApp.Dto.ToDtoConverter;
import com.backFalahApp.BackFalahApp.model.Category;
import com.backFalahApp.BackFalahApp.repository.CategoryRepository;
import com.backFalahApp.BackFalahApp.repository.CommentsRepository;
import com.backFalahApp.BackFalahApp.repository.PostsRepository;
import com.backFalahApp.BackFalahApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

public CategoryService() {

}

private CategoryRepository categoryRepository;

@Autowired
public CategoryService(
                       CategoryRepository thecategoryRepository)
{
categoryRepository = thecategoryRepository;
}



public CategoryDto createCategory(Category category) {

categoryRepository.save(category);

return ToDtoConverter.categoryToDtoConverter(category);
}



public List<CategoryDto> getAllCategories()
{
List<Category> categories = categoryRepository.findAll();
return categories.stream().map(ToDtoConverter::categoryToDtoConverter).collect(Collectors.toList());
}



}
