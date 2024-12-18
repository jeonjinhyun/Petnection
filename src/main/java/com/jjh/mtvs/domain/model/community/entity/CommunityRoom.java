package com.jjh.mtvs.domain.model.community.entity;


import com.jjh.mtvs.domain.model.community.vo.CommunityRoomAuthority;
import com.jjh.mtvs.domain.model.object.entity.Object;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "tbl_community_room")
public class CommunityRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_room_id")
    private Long id;

    @Column(name = "community_room_name")
    private String name;

    @Column(name = "community_room_img_url")
    private String imgUrl;

    @Column(name = "community_room_favorite_count")
    private Integer favoriteCount = 0;

    @Column(name = "community_room_authority")
    @Enumerated(EnumType.STRING)
    private CommunityRoomAuthority communityRoomAuthority;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "community_room_id")
    private List<Post> posts = new ArrayList<>();

    @Column(name = "community_room_creator_id")
    private Long creatorId;

    @Column(name = "community_room_created_at")
    private LocalDateTime createdAt;

    @Setter
    @Column(name = "community_room_is_favorite")
    private Boolean isFavorite;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "community_room_id")
    private List<Object> objects = new ArrayList<>();

    public void incrementFavoriteCount() {
        this.favoriteCount++;
    }

    public void decrementFavoriteCount() {
        if (this.favoriteCount > 0) {
            this.favoriteCount--;
        }
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void addCommunityObject(Object object){
        this.objects.add(object);
    }
    public void setObjects(List<Object> objects) {
        this.objects.clear();
        this.objects.addAll(objects);
    }

}