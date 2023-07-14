package com.cybersoft.osahaneat.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface FileServiceImp {
    public void init ();
    public boolean saveFile (MultipartFile file);
    public Resource loadFile (String fileName);

    public boolean deleteFile (String fileName);
    public boolean deleteAllFile ();


}
