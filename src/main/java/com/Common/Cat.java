package com.Common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Cat implements Serializable {
    private final String name;
    private final String gender;
    private final boolean longHaired;
    private final boolean roundFace;
    private final boolean lively;
    private final String picPath;
}
