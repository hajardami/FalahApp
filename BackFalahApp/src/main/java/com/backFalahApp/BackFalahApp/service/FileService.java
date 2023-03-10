package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.enumerations.ExpertDocuments;
import com.backFalahApp.BackFalahApp.exceptions.FileNullException;
import com.backFalahApp.BackFalahApp.exceptions.FileTypeInappropriateException;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.model.Expert;
import com.backFalahApp.BackFalahApp.model.Nouveautes;
import com.backFalahApp.BackFalahApp.utils.FileConfig;
import com.backFalahApp.BackFalahApp.utils.FileUtils;
import com.backFalahApp.BackFalahApp.utils.MD5;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@Service
@Transactional
@AllArgsConstructor
public class FileService {
    private final ExpertService expertService;
    private final FileConfig fileConfig;

    public void uploadExpertDocuments(Expert expert, MultipartFile file, ExpertDocuments type) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(expert.getEmail()) + "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        expertService.setExpertDocument(expert,type,documentName);
  }


    public void uploadImageUser(AppUser appUser, MultipartFile file) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(appUser.getEmail()) + "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        appUser.setPersonalphoto(documentName);
    }



    public void uploadImageAdvert(Advert advert, MultipartFile file) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(advert.getTitle()) + "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        advert.setImage(documentName);
    }

    public void uploadImageNews(Nouveautes news, MultipartFile file) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(news.getTitle()) + "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        news.setImage(documentName);
    }
}
