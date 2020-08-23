package com.majaw.lang;

import java.util.List;

import static java.util.stream.Collectors.toList;

class LangService {
    private LangRepository langRepository;

    LangService() {
        this(new LangRepository());
    }

    LangService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    List<LangDTO> findAll() {
        return langRepository.findAll().stream().map(LangDTO::new).collect(toList());

/*
        List<LangDTO> list = new ArrayList<>();
        int size = langRepository.findAll().size();
        for (int i = 0; i < size; i++) {
            list.add(new LangDTO(langRepository.findAll().get(i)));
        }
        return list;*/
    }


}
